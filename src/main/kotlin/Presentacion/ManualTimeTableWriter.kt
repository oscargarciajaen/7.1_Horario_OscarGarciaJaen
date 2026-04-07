package Presentacion

import Datos.DayOfWeek
import Datos.TimeTable
import Dominio.TimeTableWriter
import kotlin.collections.iterator

class ManualTimeTableWriter() : TimeTableWriter {

    override fun write(timeTable: TimeTable) {
        println("%63s".format(" ") + timeTable.groupName)
        timeTable.rows[0].SubjectsByDay.keys.forEach {
            if (it == DayOfWeek.MONDAY){print("%21s".format(" ") + it)}
            else if (it == DayOfWeek.TUESDAY){print("%20s".format(" ") + it)}
            else if (it == DayOfWeek.WEDNESDAY) {print("%18s".format(" ") + it) }
            else if (it == DayOfWeek.THURSDAY) {print("%16s".format(" ") + it) }
            else if (it == DayOfWeek.FRIDAY) {print("%17s".format(" ") + it) }
        }

        println("")
        for (i in 0..5){
            print(timeTable.rows[i].timeSlot.start + "/" + timeTable.rows[i].timeSlot.end)
            for (j in timeTable.rows[i].SubjectsByDay) {
                val asignatura = j.value
                print("%25s".format(asignatura))
            }
            println("")
        }
    }
}