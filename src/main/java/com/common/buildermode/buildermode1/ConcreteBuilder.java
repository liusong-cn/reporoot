package com.common.buildermode.buildermode1;

/**
 * @author:11411
 * @date: 2020/7/27 13:34
 **/
public class ConcreteBuilder implements Builder {

    private Product p;

    public ConcreteBuilder(Product p) {
        this.p = p;
    }

    @Override
    public Builder buildA() {
        p.addPart("部件A");
        return this;
    }

    @Override
    public Builder buildB() {
        p.addPart("部件B");
        return this;
    }

    @Override
    public Builder buildC() {
        p.addPart("部件C");
        return this;
    }

    @Override
    public Product getProduct() {
        return p;
    }
}
