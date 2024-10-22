package com.rupesh.project;

class Reservation 
{
    private User user;
    private Service service;

    public Reservation(User user, Service service) {
        this.user = user;
        this.service = service;
    }

    @Override
    public String toString() {
        return "Reservation for " + user.getName() + ": " + service.getServiceName() + " ($" + service.getPrice() + ")";
    }
}
