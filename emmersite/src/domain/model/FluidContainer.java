package domain.model;

public class FluidContainer
{

	

	public FluidContainer(String type, String material, int capacityInLiters,
			int contentsInLiters, String contains)
	{
		this.type = type;
		this.material = material;
		this.capacityInLiters = capacityInLiters;
		this.contentsInLiters = contentsInLiters;
		this.contains = contains;
	}
	
	public FluidContainer()
	{
		this("", "", 0,0,"");
	}

	private String type;
	private String material;
	private int capacityInLiters;
	private int contentsInLiters;
	private String contains;
	
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
}