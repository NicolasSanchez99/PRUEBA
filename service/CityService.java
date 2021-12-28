package com.example.cuadrangular.cuadrangularWS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cuadrangular.cuadrangularWS.model.City;
import com.example.cuadrangular.cuadrangularWS.repository.ICityRepository;



public class CityService implements ICityService{
	
	@Autowired
	private ICityRepository cityRP;

	@Override
	public String createCity(City city) {
		try {
			cityRP.save(city);
			return "SAVED";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		try {
			long cantidad=0;
			cantidad=cityRP.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String updateCity(City city) {
		try {
        	int busqueda= city.getIdcity();
            if(cityRP.getOne(busqueda)!=null) {
            	cityRP.delete(city);
            	cityRP.save(city);
                return "UPDATED";
            }else {
                return "ERROR";
            }
        } catch (IllegalArgumentException e) {
            return "ERROR: " + e.getMessage();
        }
	}

	@Override
	public List<City> findAll() {
		try {
			List<City> encontrado=cityRP.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String DeleteCity(City city) {
		try {
			if(cityRP.getOne(city.getIdcity())!=null) {
				cityRP.delete(city);
				return "DELETED";
			}else {
			return "ERROR";
			}
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public City ShowCity(int id) {
		City city= new City();
		try {
			if(cityRP.getOne(id)!=null) {
				city=cityRP.getOne(id);
				return city;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

}
