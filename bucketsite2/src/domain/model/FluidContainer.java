package domain.model;

public class FluidContainer
{

	private String type;
	private String material;
	private int capacityInLiters;
	private int contentsInLiters;
	private String contains;
	private int bod;

	public FluidContainer(String type, String material, int capacityInLiters,
			int contentsInLiters, String contains, int bod)
	{
		this.type = type;
		this.material = material;
		this.capacityInLiters = capacityInLiters;
		this.contentsInLiters = contentsInLiters;
		this.contains = contains;
		this.bod = bod;
	}
	
	public FluidContainer()
	{
		this("", "", 0,0,"", 0);
	}
	
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getMaterial()
	{
		return material;
	}
	public void setMaterial(String material)
	{
		this.material = material;
	}
	public int getCapacityInLiters()
	{
		return capacityInLiters;
	}
	public void setCapacityInLiters(int capacityInLiters)
	{
		this.capacityInLiters = capacityInLiters;
	}
	public int getContentsInLiters()
	{
		return contentsInLiters;
	}
	public void setContentsInLiters(int contentsInLiters)
	{
		if (contentsInLiters > this.getCapacityInLiters())
		{
			this.contentsInLiters = this.getCapacityInLiters();
		}
		else
		{
			this.contentsInLiters = contentsInLiters;
		}
	}
	public String getContains()
	{
		return contains;
	}
	public void setContains(String contains)
	{
		this.contains = contains;
	}
	
	public int getBod()
	{
		return this.bod;
	}
	
	public void setBod(int bod)
	{
		this.bod = bod;
	}
	
	public static boolean geldigBod(int bod)
	{
		return bod >= 100;
	}
	
//	public boolean valid()
//	{
//		boolean fail = true;
//		fail = this.type == null
//			|| this.material == null
//			|| this.capacityInLiters <= 0
//			|| this.contentsInLiters < 0
//			|| this.capacityInLiters > this.contentsInLiters
//			|| this.contains == null;
//		if (!fail)
//		{
//			fail = this.type.isEmpty()
//				|| this.material.isEmpty()
//				|| this.contains.isEmpty();
//		}
//		return !fail;
//	}
}