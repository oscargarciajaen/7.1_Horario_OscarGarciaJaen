package Dominio

import Datos.TimeTableInputData
import Presentacion.ConsoleInput
import Presentacion.LibraryTimeTableWriter
import Presentacion.ManualTimeTableWriter

class TimeTableManager() {

    companion object {

        private val input = ConsoleInput()

        private val builder = TimeTableBuilder()

        fun execute(){
            val groupName = input.readGroupName()
            val timeslots = input.readTimeSlots()
            val subjets = input.readSubjects(timeslots)
            val timeTableInputData = TimeTableInputData(groupName, timeslots, subjets)
            val timeTable = builder.build(timeTableInputData)
            val option = input.selectWriter()
            if (option == "1"){
                val writer = ManualTimeTableWriter()
                writer.write(timeTable)
            } else if (option == "2") {
                val writer = LibraryTimeTableWriter()
                writer.write(timeTable)
            }
        }
    }
}