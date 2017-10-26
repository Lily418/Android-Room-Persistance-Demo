package com.example.lily.roomtest

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

/**
 * Created by Lily Hoskin on 25/10/2017.
 */

@Dao
interface PetDao {
    @Query("select * from pet")
    fun getAllPets(): List<Pet>

    @Query("select * from pet where id = :id")
    fun findPetById(id: Long): Pet

    @Insert(onConflict = REPLACE)
    fun insertPet(pet: Pet) : Long

    @Update(onConflict = REPLACE)
    fun updatePet(pet: Pet)

    @Delete
    fun deletePerson(pet: Pet)
}