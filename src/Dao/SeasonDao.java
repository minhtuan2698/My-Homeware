package Dao;

import java.util.ArrayList;

import Model.Season;

public interface SeasonDao {
	public Season GetNameSeason(int id_season);
	public ArrayList<Season> GetSeason();

}
