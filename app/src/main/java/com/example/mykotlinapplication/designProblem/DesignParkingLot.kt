package com.example.mykotlinapplication.designProblem


import java.util.*

import java.util.*

enum class VehicleType { BIKE, CAR, TRUCK }

abstract class Vehicle(val type: VehicleType, val license: String)

class Car(license: String) : Vehicle(VehicleType.CAR, license)

class ParkingSpot(val type: VehicleType) {
    var isFree: Boolean = true
    var vehicle: Vehicle? = null

    fun park(v: Vehicle): Boolean {
        return if (isFree && v.type == type) {
            vehicle = v
            isFree = false
            true
        } else {
            false
        }
    }

    fun leave() {
        vehicle = null
        isFree = true
    }
}

class ParkingLot(private val spots: List<ParkingSpot>) {
    fun parkVehicle(v: Vehicle): Boolean {
        for (s in spots) {
            if (s.park(v)) return true
        }
        return false
    }

    fun unparkVehicle(v: Vehicle) {
        for (s in spots) {
            if (s.vehicle == v) {
                s.leave()
                break
            }
        }
    }
}

fun main() {
    val spots = listOf(
        ParkingSpot(VehicleType.CAR),
        ParkingSpot(VehicleType.BIKE),
        ParkingSpot(VehicleType.TRUCK)
    )

    val parkingLot = ParkingLot(spots)

    val car1 = Car("TN10AB1234")
    val car2 = Car("TN22XY5678")

    println("Parking car1: ${parkingLot.parkVehicle(car1)}")
    println("Parking car2: ${parkingLot.parkVehicle(car2)}")

    parkingLot.unparkVehicle(car1)
    println("Car1 left the parking lot.")
    println("Parking car2 again: ${parkingLot.parkVehicle(car2)}")
}









