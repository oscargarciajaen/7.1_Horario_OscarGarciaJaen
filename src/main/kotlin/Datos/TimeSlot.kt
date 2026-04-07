package Datos

class TimeSlot(val start: String, val end: String){

    override fun toString(): String {
        return "Start: ${this.start}   End: $end"
    }

}