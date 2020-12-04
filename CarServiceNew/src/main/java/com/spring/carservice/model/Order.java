package com.spring.carservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Order -заказ на исполнение. Как только зарегестрированный в сервисе автомобиль поступает на диагностику,
 * ему присваевается механик и цена диагностики
 */
public class Order {
    /**
     * publicationDate -дата создания заказа на обслуживание автомобиля.
     */
    private LocalDateTime publicationDate;
    /**
     * car -автомобиль поступивший на обслуживание.
     */
    private Car car;
    /**
     * mechanic -механик осблуживающий Т.С.
     */
    private Mechanic mechanic;
    /**
     * price -оцененный сервисом труд механика, выраженный в денежном эквиваленте.
     */

    private BigDecimal price;

    public Order(LocalDateTime publicationDate, Car car, Mechanic mechanic, BigDecimal price) {
        this.publicationDate = publicationDate;
        this.car = car;
        this.mechanic = mechanic;
        this.price = price;
    }

    public Order() {
    }

    ;

    @Override
    public String toString() {
        return "Order{" +
                "publicationDate=" + publicationDate +
                ", car=" + car +
                ", mechanic=" + mechanic +
                ", price=" + price +
                '}';
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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
