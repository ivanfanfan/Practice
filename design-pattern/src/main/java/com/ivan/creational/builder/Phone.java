package com.ivan.creational.builder;

public class Phone {
    private String cpu;
    private String memory;
    private String price;

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.memory = builder.memory;
        this.price = builder.price;
    }

    protected static final class Builder {
        private String cpu;
        private String memory;
        private String price;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder price(String price){
            this.price = price;
            return this;
        }
        public Phone build(){
            return new Phone(this);
        }
    }
}
