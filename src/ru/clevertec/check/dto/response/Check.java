package ru.clevertec.check.dto.response;

import ru.clevertec.check.exception.PrintableException;

import java.io.IOException;
import java.io.Writer;

public class Check implements Printable {

    private final CheckTitle checkTitle;
    private final CheckBody checkBody;
    private final CheckTotal checkTotal;

    public Check(CheckTitle checkTitle,
                 CheckBody checkBody,
                 CheckTotal checkTotal) {
        this.checkTitle = checkTitle;
        this.checkBody = checkBody;
        this.checkTotal = checkTotal;
    }

    public CheckTitle getCheckTitle() {
        return checkTitle;
    }

    public CheckBody getCheckBody() {
        return checkBody;
    }

    public CheckTotal getCheckTotal() {
        return checkTotal;
    }

    @Override
    public void print(Writer writer) {
        try {
            checkTitle.print(writer);
            writer.append('\n');
            checkBody.print(writer);
            writer.append('\n');
            checkTotal.print(writer);
            writer.append('\n');

        } catch (IOException e) {
            throw new PrintableException();
        }
    }

    public static DiscountCheck.Builder builder() {
        return new DiscountCheck.Builder();
    }

    public static class Builder {

        private CheckTitle checkTitle;
        private CheckBody checkBody;
        private CheckTotal checkTotal;

        public Builder setCheckTitle(CheckTitle checkTitle) {
            this.checkTitle = checkTitle;
            return this;
        }

        public Builder setCheckBody(CheckBody checkBody) {
            this.checkBody = checkBody;
            return this;
        }

        public Builder setCheckTotal(CheckTotal checkTotal) {
            this.checkTotal = checkTotal;
            return this;
        }

        public Check build() {
            return new Check(checkTitle, checkBody, checkTotal);
        }
    }
}
