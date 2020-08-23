package data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class CarsAppDatabase extends RoomDatabase {

    public abstract CarDAO getCarDAO();
}
