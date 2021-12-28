package com.example.cuadrangular.cuadrangularWS.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.example.cuadrangular.cuadrangularWS.model.Team;
import com.example.cuadrangular.cuadrangularWS.model.Versus;
import com.example.cuadrangular.cuadrangularWS.repository.IVersusRepository;


public class VersusService implements IVersusService{
	
	@Autowired
	private IVersusRepository vrepo;
	
	private TeamService ts;
	private VersusService vs;

	@Override
	public String createVersus(Versus match) {
		try {
			
			for (int i = 0; i < vs.fixture(ts.findAll()).length; i++) {
				if (i % 2== 0) {
					int cast= Integer.parseInt(vs.fixture(ts.findAll())[i].toString());
					match.setHosts(cast);
				}else {
					int cast= Integer.parseInt(vs.fixture(ts.findAll())[i].toString());
					match.setVisitors(cast);
				}
			}
			vrepo.save(match);
			return "SAVED";
		} catch (IllegalArgumentException e) {
			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String updateVersus(Versus match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Versus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteVersus(Versus match) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Versus ShowMatch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] fixture(List<Team> lista) {
		
        /* Fixture 4 teams default /  3 series = 
        
        1° vs 2°    1° vs 3°    1° vs 4°
        3° vs 4°    2° vs 4°    2° vs 3°
    
     */
		
		String fixture1[] = new String[2];
		String fixture2[] = new String[2];
		String fixture3[] = new String[2];
		String fixture4[] = new String[2];
		String fixture5[] = new String[2];
		String fixture6[] = new String[2];
		lista=ts.findAll();
		String equipos[] = new String[4];
		
        for (int i = 0; i < equipos.length; i++) {
        	equipos[i]=lista.get(i).toString();
        	for (int j = 0; i < fixture1.length; j++) {
        		fixture1[j]=equipos[0].toString();
        		fixture1[j]=equipos[1].toString();
        		fixture2[j]=equipos[2].toString();
        		fixture2[j]=equipos[3].toString();
        		fixture3[j]=equipos[0].toString();
        		fixture3[j]=equipos[2].toString();
        		fixture4[j]=equipos[1].toString();
        		fixture4[j]=equipos[3].toString();
        		fixture5[j]=equipos[0].toString();
        		fixture5[j]=equipos[3].toString();
        		fixture6[j]=equipos[1].toString();
        		fixture6[j]=equipos[2].toString();
        		
        	}
        	
        }
        String [] cat = Stream.of(fixture1, fixture2, fixture3, fixture4, fixture5, fixture6).flatMap(Stream::of).toArray(String[]::new);
		return cat;
                
        	
		
	}

}
