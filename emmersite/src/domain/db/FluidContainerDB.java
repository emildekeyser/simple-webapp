package domain.db;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import domain.model.FluidContainer;

public class FluidContainerDB
{
	private ArrayList<FluidContainer> containers;
	
	public FluidContainerDB()
	{
		this.containers = new ArrayList<FluidContainer>();
		genRandomdb();
	}
	
	private void genRandomdb()
	{
		String[] types = {"Emmer", "Vat"};
		String[] materialen = {"Ceder", "Inox", "Eik", "Polyester"};
		String[] vloeistoffen = {"Water", "Wijn", "Lijm", "Olie"};
		
		int n = ThreadLocalRandom.current().nextInt(5, 10);
		for (int i = 0; i < n; i++)
		{
			FluidContainer container =  new FluidContainer();
			
			int r = ThreadLocalRandom.current().nextInt(types.length - 1);
			container.setType(types[r]);
			
			r = ThreadLocalRandom.current().nextInt(materialen.length - 1);
			container.setMaterial(materialen[r]);
			
			r = ThreadLocalRandom.current().nextInt(100);
			container.setCapacityInLiters(r);
			
			r = ThreadLocalRandom.current().nextInt(r);
			container.setContentsInLiters(r);
			
			r = ThreadLocalRandom.current().nextInt(vloeistoffen.length - 1);
			container.setContains(vloeistoffen[r]);
			
			this.containers.add(container);
		}
	}

	public ArrayList<FluidContainer> getContainers()
	{
		return this.containers;
	}
	
	public void deleteContainer(FluidContainer container)
	{
		this.containers.remove(container);
	}

	public float averageFilled()
	{
		float avg = 0;
		for (FluidContainer container : containers)
		{
			avg += container.getContentsInLiters();
		}
		
		return avg / containers.size();
	}
	
	public void add(FluidContainer container)
	{
		this.containers.add(container);
	}

}