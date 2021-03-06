package rex.src.deduplication.impl

import org.apache.spark.sql.Row
import rex.src.deduplication.DuplicateStrategy

import scala.util.{Failure, Success, Try}

/**
  * An implementation of Strategy Type to find row having minimum value of strategy field specified
  */
object MinDuplicateStrategy extends DuplicateStrategy {

  /*Returns the row with the minimum value of "strategyField" column in rowSeq.*/
  override def deDuplicate(rowSeq: Seq[Row], strategyField: String): Row = {
    if (!rowSeq.isEmpty)
      rowSeq.minBy(row => {
        if (row != null && row.getAs(strategyField) != null)
          Try(row.getAs(strategyField).toString.toInt) match {
            case Success(x) => x
            case Failure(x) => 0
          }
        else
          Int.MinValue
      })
    else Row.empty
  }


  /* return sorted seq[row] based on supplied field
  custom row comparator(sortRowBasedOnFieldValue) passed for sorting */
  override def sortRowsAsPerStrategy(rowSeq: Seq[Row], strategyField: String): Seq[Row] = {
    rowSeq.sortWith { case (row1, row2) =>
      sortRowBasedOnFieldValue(row2, row1, strategyField)
    }

  }
}

