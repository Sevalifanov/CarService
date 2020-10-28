package com.spring.carService.model;

import java.util.Date;

public class Order {
    /**
     * Date - дата приемки, Car - машина, Mechanic -механик, Price -цена за услугу
     */
    private Date publicationDate;
    private Car car;
    private Mechanic mechanic;
    private Long price;

    public Order(Date publicationDate, Car car, Mechanic mechanic, Long price) {
        this.publicationDate = publicationDate;
        this.car = car;
        this.mechanic = mechanic;
        this.price = price;
    }
    public Order(){};

    @Override
    public String toString() {
        return "Order{" +
                "publicationDate=" + publicationDate +
                ", car=" + car +
                ", mechanic=" + mechanic +
                ", price=" + price +
                '}';
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
