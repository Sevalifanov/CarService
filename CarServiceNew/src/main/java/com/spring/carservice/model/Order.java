package com.spring.carservice.model;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getPublicationDate(), order.getPublicationDate()) &&
                Objects.equals(getCar(), order.getCar()) &&
                Objects.equals(getMechanic(), order.getMechanic()) &&
                Objects.equals(getPrice(), order.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublicationDate(), getCar(), getMechanic(), getPrice());
    }
}
