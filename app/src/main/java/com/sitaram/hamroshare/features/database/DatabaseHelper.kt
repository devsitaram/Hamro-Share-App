package com.sitaram.hamroshare.features.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.SQLException

class DatabaseHelper : SQLiteOpenHelper {

    // create the companion object
    companion object {
        // initialize the variable
        private const val DATABASE_NAME = "UserDB"
        private const val DATABASE_VIRION = 1
        private const val TABLE_NAME = "user"
        private const val KEY_ID = "id"
        const val KEY_NAME = "username"
        const val KEY_PASSWORD = "password"
    }

    // create the constructor
    constructor(context: Context?) : super(context, DATABASE_NAME, null, DATABASE_VIRION)

    // create the database
    override fun onCreate(db: SQLiteDatabase) {
        // create the database table
        db.execSQL(
            " CREATE TABLE " + TABLE_NAME +
                    "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT, " + KEY_PASSWORD + " TEXT " + ")"
        )
    }

    // CRUD statements
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // drop the database table
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // insert the user
    fun registerUser(username: String?, userPassword: String?) {
        // SQLiteDatabase databaseRead = this.getReadableDatabase(); // read only select query
        val databaseWrite = this.writableDatabase // write only Insert, update, delete query
        val values = ContentValues()
        values.put(KEY_NAME, username)
        values.put(KEY_PASSWORD, userPassword)
        databaseWrite.insert(TABLE_NAME, null, values) // insert the user data in database
    }

    // get data from database
    fun fetchUsers(name: String, password: String): Boolean? {
        val isBoolean: Boolean? = null
        try {
            // create the object of sqLiteDatabase and call the getReadableDatabase methods
            val sqLiteDatabase = this.readableDatabase

            @SuppressLint("Recycle")
            val cursor = sqLiteDatabase.rawQuery("SELECT * FROM $TABLE_NAME", null)
            // val arrayList = ArrayList<UserEntity>()
            // use the while loop
            while (cursor.moveToNext()) {

                // store the data in variable
                val userName = cursor.getString(1)
                val userPassword = cursor.getString(2)

                // print
                Log.e("Name: ", userName)
                Log.e("Password: ", userPassword)
                Log.d("*********", "-------------")

                return if (name == userName && password == userPassword) {
                    isBoolean == true
                } else {
                    return isBoolean == false
                }

//            val userEntity = UserEntity()
//            userEntity.id = cursor.getInt(0)
//            userEntity.username = cursor.getString(1)
//            userEntity.userPassword = cursor.getString(2)
//            arrayList.add(userEntity) // add the users details

            }
            Log.e("Boolean: ", isBoolean.toString())
            return isBoolean
        } catch (ex: SQLException) {
            // handle ClassNotFoundException
            ex.printStackTrace();
            return false;
        }
//        return arrayList
    }
}