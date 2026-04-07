package Presentacion

import Datos.TimeSlot
import Datos.DayOfWeek
import Datos.TimeTableInputData

class ConsoleInput() {

    fun readData(groupName: String, timeSlots: List<TimeSlot>, subjects: Map<TimeSlot, Map<DayOfWeek, String>>): TimeTableInputData{
        val timeTableInputData = TimeTableInputData(groupName, timeSlots, subjects)
        return timeTableInputData
    }

    fun readGroupName():String{
        var groupName: String? = null

        do {
            println("Please enter group Name: ")
            val input = readLine()
            if (input != null && input.isNotBlank()){
                groupName = input
            }
        } while (groupName == null)
        return groupName
    }

    fun readTimeSlots():List<TimeSlot>{

        val timeSlots: MutableList<TimeSlot> = mutableListOf()
        val regularExpresion = """^([0-1][0-9]|2[0-3]):[0-5][0-9]$""".toRegex()

        for (i in  1..6){

            var start: String? = null
            do {
                println("Please insert the start time for hour $i in format 00:00 : ")
                val entry = readLine()
                if (entry != null && entry.matches(regularExpresion)){
                    start = entry
                }
            } while (start == null)

            var end: String? = null
            do {
                println("Please insert the end time for hour $i in format 00:00 : ")
                val input = readLine()
                if (input != null && input.matches(regularExpresion)){
                    end = input
                }
            } while (end == null)

            timeSlots.add(TimeSlot(start, end))
        }
       return timeSlots
    }

    fun readSubjects(timeSlots: List<TimeSlot>): Map<TimeSlot, Map<DayOfWeek, String>>{
        val subjects: MutableMap<TimeSlot, MutableMap<DayOfWeek, String>> = mutableMapOf()
        val daysOfWeek = mutableListOf<DayOfWeek>(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)
        for (i in timeSlots){
            subjects[i] = mutableMapOf<DayOfWeek, String>()
            for (j in 0..4){
                var subject : String? = null
                do {
                    println("Insert subject for ${daysOfWeek[j]} at ${i}: ")
                    val entry = readLine()
                    if (entry != null && entry.isNotBlank()){
                        subject = entry
                    }
                }while (subject == null)
                subjects[i]?.put(daysOfWeek[j], subject)
            }
        }
        return subjects
    }

    fun selectWriter(): String {
        var option: String? = null

        do {
            println("1. Manual Writer")
            println("2. Library Writer")
            println("Please insert the option: ")
            val input = readLine()
            if (input != null && (input == "1" || input == "2")){
                option = input
            }

        } while (option == null)
        return option
    }

}