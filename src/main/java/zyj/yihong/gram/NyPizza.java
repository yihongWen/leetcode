package zyj.yihong.gram;

import java.util.Objects;

import static zyj.yihong.gram.NyPizza.Size.SMALL;

public class NyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static void main(String[] args) {
        new NyPizza.Builder(SMALL).addTopping(Topping.SAUSAGE).build();
    }

}