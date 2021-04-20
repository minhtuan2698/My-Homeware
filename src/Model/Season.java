package Model;

public class Season {
	private int ID_Season;
	private String Name_Season;
	private String DateStart;
	private String DateEnd;
	public Season() {
		super();
	}
	public Season(int iD_Season, String name_Season, String dateStart, String dateEnd) {
		super();
		ID_Season = iD_Season;
		Name_Season = name_Season;
		DateStart = dateStart;
		DateEnd = dateEnd;
	}
	public int getID_Season() {
		return ID_Season;
	}
	public void setID_Season(int iD_Season) {
		ID_Season = iD_Season;
	}
	public String getName_Season() {
		return Name_Season;
	}
	public void setName_Season(String name_Season) {
		Name_Season = name_Season;
	}
	public String getDateStart() {
		return DateStart;
	}
	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}
	public String getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}
	
	

}
