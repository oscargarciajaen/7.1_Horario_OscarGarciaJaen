package Dominio

import Datos.TimeTable
import Datos.TimeTableInputData
import Datos.TimeTableRow

class TimeTableBuilder() {

    fun build(inputData: TimeTableInputData): TimeTable {

        val listTimeTableRow = mutableListOf<TimeTableRow>()
        for (i in inputData.timeSlots){
            val timeTableRow = TimeTableRow(i, inputData.subjectsBySlot.getValue(i))
            listTimeTableRow.add(timeTableRow)
        }
        val timeTable = TimeTable(inputData.groupName, listTimeTableRow)
        return timeTable
    }
}