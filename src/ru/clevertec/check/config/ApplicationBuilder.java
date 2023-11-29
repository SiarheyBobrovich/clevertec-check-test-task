package ru.clevertec.check.config;

import ru.clevertec.check.controller.MainOrderController;
import ru.clevertec.check.dto.CommandLineArgumentContainer;
import ru.clevertec.check.factory.CheckFactory;
import ru.clevertec.check.factory.impl.CheckFactoryImpl;
import ru.clevertec.check.mapper.ArgMapper;
import ru.clevertec.check.mapper.DiscountCardMapper;
import ru.clevertec.check.mapper.ProductMapper;
import ru.clevertec.check.mapper.impl.DiscountCardMapperImpl;
import ru.clevertec.check.mapper.impl.ProductMapperImpl;
import ru.clevertec.check.processor.MainOrderProcessor;
import ru.clevertec.check.processor.impl.MainOrderProcessorImpl;
import ru.clevertec.check.repository.DiscountCardRepository;
import ru.clevertec.check.repository.ProductRepository;
import ru.clevertec.check.service.DiscountCardService;
import ru.clevertec.check.service.OrderService;
import ru.clevertec.check.service.PrintService;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.service.impl.DiscountCardServiceImpl;
import ru.clevertec.check.service.impl.OrderServiceImpl;
import ru.clevertec.check.service.impl.PrintServiceImpl;
import ru.clevertec.check.service.impl.ProductServiceImpl;
import ru.clevertec.check.validation.impl.ValidatorImpl;

public class ApplicationBuilder {

    private final MainOrderProcessor mainOrderProcessor;

    private ApplicationBuilder(String readFromFilePath, String saveToFilePath) {
        ArgMapper argMapper = new ArgMapper();
        PrintService printService = new PrintServiceImpl();

        ProductRepository productRepository = RepositoryConfig.getProductRepository(readFromFilePath);
        DiscountCardRepository discountCardRepository = RepositoryConfig.getDiscountCardRepository(
                ".\\src\\resources\\discountCards.csv");

        MainOrderController mainOrderController = getMainOrderController(discountCardRepository, productRepository);

        mainOrderProcessor = new MainOrderProcessorImpl(argMapper, printService, mainOrderController, new ValidatorImpl(), saveToFilePath);
    }

    private MainOrderController getMainOrderController(DiscountCardRepository discountCardRepository, ProductRepository productRepository) {
        DiscountCardMapper discountCardMapper = new DiscountCardMapperImpl();
        DiscountCardService discountCardService = new DiscountCardServiceImpl(discountCardRepository, discountCardMapper);
        ProductMapper productMapper = new ProductMapperImpl();
        ProductService productService = new ProductServiceImpl(productRepository, productMapper);
        CheckFactory checkFactory = new CheckFactoryImpl();
        OrderService orderService = new OrderServiceImpl(productService, discountCardService, checkFactory);

        return new MainOrderController(orderService);
    }

    public static void run(String[] args) {
        CommandLineArgumentContainer commandLineArgumentContainer = CommandLineArgumentResolver.splitArgs(args);
        ApplicationBuilder applicationBuilder = new ApplicationBuilder(
                commandLineArgumentContainer.getReadFromFilePath(), commandLineArgumentContainer.getSaveToFilePath());

        applicationBuilder.mainOrderProcessor.processOrder(commandLineArgumentContainer.getAppArguments());
    }
}
