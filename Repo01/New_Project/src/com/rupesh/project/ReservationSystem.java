package com.rupesh.project;

import java.util.ArrayList;
import java.util.List;

class ReservationSystem 
{
	
	private static final String YELLOW = "\033[1;33m"; // RED
	
	private static final String RESET = "\033[0m"; // Text Reset
    private List<User> users;
    private List<Service> services;
    private List<Reservation> reservations;

    public ReservationSystem() {
        users = new ArrayList<>();
        setServices(new ArrayList<>());
        reservations = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addService(Service service) 
    {
        getServices().add(service);
    }

    public void makeReservation(User user, Service service) {
        Reservation reservation = new Reservation(user, service);
        reservations.add(reservation);
        System.out.println(YELLOW+"Reservation made successfully!"+RESET);
        System.out.println(reservation);
    }

    public void displayServices() {
        System.out.println("Available Services:");
        for (int i = 0; i < getServices().size(); i++) {
            System.out.println((i + 1) + ". " + getServices().get(i).getServiceName() + " - $" + getServices().get(i).getPrice());
        }
    }

	List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
}


