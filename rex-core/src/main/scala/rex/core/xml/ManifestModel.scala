// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package rex.core.xml

case class DataFlows(DataSources: Option[rex.core.xml.DataSourcesType] = None,
                     Properties: Option[rex.core.xml.PropertiesType] = None,
                     DataFlow: Seq[rex.core.xml.DataFlowType] = Nil,
                     attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes.get("@name") map {
    _.as[String]
  }
}


trait Type

object Type {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.Type]): Type = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: Type) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Transform extends Type {
  override def toString = "Transform"
}

case object SQL extends Type {
  override def toString = "SQL"
}

case object Export extends Type {
  override def toString = "Export"
}

case object Ingest extends Type {
  override def toString = "Ingest"
}

case object Reporting extends Type {
  override def toString = "Reporting"
}

case object Reconcile extends Type {
  override def toString = "Reconcile"
}


case class FlowType(Ingest: Option[rex.core.xml.IngestType] = None,
                    Transformations: Option[rex.core.xml.TransformationsType] = None,
                    Sql: Option[rex.core.xml.SqlType] = None,
                    Export: Option[rex.core.xml.ExportType] = None,
                    Reporting: Option[rex.core.xml.ReportingType] = None,
                    Reconciliation: Option[rex.core.xml.ReconciliationType] = None,
                    attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val id = attributes("@id").as[String]
  lazy val typeValue = attributes("@type").as[Type]
}


case class ExportFileType(TargetStore: String,
                          FileLocation: String,
                          Partition: Option[rex.core.xml.PartitionType] = None,
                          Mode: Option[String] = None,
                          Delimiter: Option[String] = None,
                          IncludeHeader: Option[Boolean] = None,
                          attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) extends ExportTypeOption {
  lazy val format = attributes("@format").as[ExportFormat]
}


case class AggregationsType(Aggregation: Seq[rex.core.xml.AggregationType] = Nil)


case class GroupByType(GroupByColumn: Seq[String] = Nil,
                       AggregateColumn: Seq[rex.core.xml.AggregationType] = Nil)
      


case class ColumnListType(Column: Seq[String] = Nil)


case class SqlType(Query: String,
                   attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val registerAsTempTable = attributes.get("@registerAsTempTable") map {
    _.as[Boolean]
  }
  lazy val applyondataref = attributes("@applyondataref").as[String]
}


case class RenamesType(Column: Seq[rex.core.xml.RenameType] = Nil)


case class AddColumnsType(Column: Seq[rex.core.xml.AddColumnType] = Nil)


case class DeleteColumnType(Column: Seq[String] = Nil)


trait Aggregator

object Aggregator {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.Aggregator]): Aggregator = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: Aggregator) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object SUM extends Aggregator {
  override def toString = "SUM"
}

case object MAX extends Aggregator {
  override def toString = "MAX"
}

case object MIN extends Aggregator {
  override def toString = "MIN"
}

case object COUNT extends Aggregator {
  override def toString = "COUNT"
}

case object AVG extends Aggregator {
  override def toString = "AVG"
}


case class AggregationType(value: String,
                           attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val aggregator = attributes("@aggregator").as[Aggregator]
  lazy val alias = attributes("@alias").as[String]
  lazy val decimalPlaces = attributes.get("@decimalPlaces") map {
    _.as[Int]
  }
}


case class RenameType(value: String,
                      attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val existingName = attributes("@existingName").as[String]
  lazy val newName = attributes("@newName").as[String]
}


trait ValueFrom

object ValueFrom {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.ValueFrom]): ValueFrom = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ValueFrom) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Literal extends ValueFrom {
  override def toString = "literal"
}

case object FromProperties extends ValueFrom {
  override def toString = "fromProperties"
}

case object FromStandardEnvVariable extends ValueFrom {
  override def toString = "fromStandardEnvVariable"
}


case class AddColumnType(value: String,
                         attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val dataType = attributes.get("@dataType") map {
    _.as[ColumnDataType]
  }
  lazy val valueFrom = attributes("@valueFrom").as[ValueFrom]
}


case class ColumnTransformationType(AddNew: Option[rex.core.xml.AddColumnsType] = None,
                                    Delete: Option[rex.core.xml.DeleteColumnType] = None,
                                    Rename: Option[rex.core.xml.RenamesType] = None)
      


case class DataFlowType(Flow: Seq[rex.core.xml.FlowType] = Nil)


case class TransformationsType(Transformation: Seq[rex.core.xml.TransformationType] = Nil)


case class HiveTableType(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) extends ExportTypeOption {
  lazy val tableName = attributes.get("@tableName") map {
    _.as[String]
  }
}


trait TransCategory

object TransCategory {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.TransCategory]): TransCategory = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: TransCategory) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object SchemaTransformation extends TransCategory {
  override def toString = "SchemaTransformation"
}

case object ColumnTransformation extends TransCategory {
  override def toString = "ColumnTransformation"
}

case object GroupByTransformation extends TransCategory {
  override def toString = "GroupByTransformation"
}

case object SimpleFilterTransformation extends TransCategory {
  override def toString = "SimpleFilterTransformation"
}

case object CustomFilterTransformation extends TransCategory {
  override def toString = "CustomFilterTransformation"
}

case object CustomTransformation extends TransCategory {
  override def toString = "CustomTransformation"
}

case object JoinTransformation extends TransCategory {
  override def toString = "JoinTransformation"
}

case object SQLTransformation extends TransCategory {
  override def toString = "SQLTransformation"
}

case object DeDuplicationTransformation extends TransCategory {
  override def toString = "DeDuplicationTransformation"
}

case object ExpressionTransformation extends TransCategory {
  override def toString = "ExpressionTransformation"
}


case class Expression(RowExpression: Option[rex.core.xml.ExpressionRowType] = None,
                      ColumnExpression: Option[rex.core.xml.ExpressionColumnType] = None,
                      FilterExpression: Option[rex.core.xml.ExpressionFilterType] = None)
      


case class TransformationType(ColumnTransformations: Option[rex.core.xml.ColumnTransformationType] = None,
                              GroupByTransformation: Option[rex.core.xml.GroupByType] = None,
                              JoinTransformation: Option[rex.core.xml.JoinTransformType] = None,
                              DeDuplication: Option[rex.core.xml.DeDuplicationType] = None,
                              Expression: Option[rex.core.xml.Expression] = None,
                              attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val transCategory = attributes("@transCategory").as[TransCategory]
  lazy val applyondataref = attributes("@applyondataref").as[String]
}


trait ModeType

object ModeType {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.ModeType]): ModeType = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ModeType) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Append extends ModeType {
  override def toString = "Append"
}

case object Overwrite extends ModeType {
  override def toString = "Overwrite"
}

case object ErrorIfExists extends ModeType {
  override def toString = "ErrorIfExists"
}

case object Ignore extends ModeType {
  override def toString = "Ignore"
}


case class DataSourcesType(DataSource: Seq[rex.core.xml.DataSourceType] = Nil)


case class DataSourceType(datasourcetypeoption: scalaxb.DataRecord[rex.core.xml.DataSourceTypeOption],
                          attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val typeValue = attributes("@type").as[SourceType]
  lazy val name = attributes("@name").as[String]
}


trait DataSourceTypeOption

case class DatabaseType(Query: String,
                        Connection: String) extends DataSourceTypeOption
      

trait Format

object Format {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.Format]): Format = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: Format) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object CsvValue extends Format {
  override def toString = "csv"
}

case object ParquetValue extends Format {
  override def toString = "parquet"
}

case object Orc extends Format {
  override def toString = "orc"
}

case object Text extends Format {
  override def toString = "text"
}

case object JsonValue extends Format {
  override def toString = "json"
}


case class FileType(DirectoryPath: String,
                    FileNameOrPattern: Option[String] = None,
                    TopLinesToIgnore: Option[Int] = None,
                    BottomLinesToIgnore: Option[Int] = None,
                    Quote: Option[String] = None,
                    Delimiter: Option[String] = None,
                    Header: Option[Boolean] = None,
                    SchemaFilePath: Option[String] = None,
                    Schema: Option[rex.core.xml.SchemaType] = None,
                    Tags: Option[String] = None,
                    WithColumn: Seq[rex.core.xml.WithColumnType] = Nil,
                    attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) extends DataSourceTypeOption {
  lazy val name = attributes.get("@name") map {
    _.as[String]
  }
  lazy val format = attributes("@format").as[Format]
}


case class WithColumnType(value: String,
                          attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
}


case class PropertiesType(Property: Seq[rex.core.xml.PropertyType] = Nil,
                          PropertyFilePath: Option[rex.core.xml.PropertyFilePathType] = None)
      


case class PropertyFilePathType(value: String,
                                attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val propertyWithPrefix = attributes.get("@propertyWithPrefix") map {
    _.as[String]
  }
}


case class PropertyType(Key: String,
                        Value: String,
                        attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes.get("@name") map {
    _.as[String]
  }
}


case class IngestType(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val applyondataref = attributes("@applyondataref").as[String]
  lazy val name = attributes("@name").as[String]
}


trait SourceType

object SourceType {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.SourceType]): SourceType = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: SourceType) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object File extends SourceType {
  override def toString = "file"
}

case object Db extends SourceType {
  override def toString = "db"
}


case class ReportingSql(value: String,
                        attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
}


case class ReportingType(ReportingSql: Seq[rex.core.xml.ReportingSql] = Nil,
                         PublishTo: String,
                         PublishingPath: String,
                         Mode: Option[String] = None,
                         attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val applyondataref = attributes("@applyondataref").as[String]
}


trait Side

object Side {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.Side]): Side = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: Side) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Source extends Side {
  override def toString = "source"
}

case object Target extends Side {
  override def toString = "target"
}


case class Strategy(value: String,
                    attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val columns = attributes.get("@columns") map {
    _.as[String]
  }
}


case class DeDuplicationType(DeDupColumns: rex.core.xml.ColumnListType,
                             Strategy: Option[rex.core.xml.Strategy] = None,
                             attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val side = attributes.get("@side") map {
    _.as[Side]
  }
}


case class DateColumn(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes.get("@name") map {
    _.as[String]
  }
  lazy val sourceFormat = attributes.get("@sourceFormat") map {
    _.as[String]
  }
  lazy val targetFormat = attributes.get("@targetFormat") map {
    _.as[String]
  }
}


case class DateColumnsType(DateColumn: Seq[rex.core.xml.DateColumn] = Nil)


trait Mode

object Mode {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.Mode]): Mode = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: Mode) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Required extends Mode {
  override def toString = "required"
}

case object IgnoreValue extends Mode {
  override def toString = "ignore"
}


case class SelectColumnsWithModeType(Column: Seq[String] = Nil,
                                     attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val mode = attributes.get("@mode") map {
    _.as[Mode]
  }
}


case class ReconcilerType(ClassName: String)


case class ReconciliationType(Source: String,
                              Target: String,
                              ComparisonKey: rex.core.xml.ColumnListType,
                              DateColumns: Option[rex.core.xml.DateColumnsType] = None,
                              NumericColumns: Option[rex.core.xml.ColumnListType] = None,
                              ReconcileColumns: Option[rex.core.xml.SelectColumnsWithModeType] = None,
                              Reconciler: Option[rex.core.xml.ReconcilerType] = None,
                              CaseColumns: Option[rex.core.xml.SelectColumnsWithModeType] = None,
                              AdditionalRequiredFields: Option[rex.core.xml.AdditionalFieldsType] = None,
                              DeDuplicationStrategy: Seq[rex.core.xml.DeDuplicationType] = Nil,
                              attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val applyondataref = attributes("@applyondataref").as[String]
  lazy val name = attributes("@name").as[String]
}


case class ExportType(exporttypeoption: Option[scalaxb.DataRecord[rex.core.xml.ExportTypeOption]] = None,
                      attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val applyondataref = attributes("@applyondataref").as[String]
}


trait ExportTypeOption

case class AdditionalFieldsType(source: rex.core.xml.ColumnListType,
                                target: rex.core.xml.ColumnListType)
      


case class Column(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val typeValue = attributes.get("@type") map {
    _.as[String]
  }
  lazy val isNullable = attributes.get("@isNullable") map {
    _.as[Boolean]
  }
  lazy val isNew = attributes.get("@isNew") map {
    _.as[Boolean]
  }
  lazy val expr = attributes("@expr").as[String]
}


case class ExpressionColumnType(Column: Seq[rex.core.xml.Column] = Nil)


case class Column2(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val name = attributes("@name").as[String]
  lazy val typeValue = attributes.get("@type") map {
    _.as[String]
  }
  lazy val isNullable = attributes.get("@isNullable") map {
    _.as[Boolean]
  }
  lazy val isNew = attributes.get("@isNew") map {
    _.as[Boolean]
  }
}


case class ExpressionRowType(Column: Seq[rex.core.xml.Column2] = Nil,
                             Expr: String)
      


case class ExpressionFilterType(Expr: String)


case class SchemaColumnType(value: String,
                            attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val dataType = attributes.get("@dataType") map {
    _.as[ColumnDataType]
  }
  lazy val isNullable = attributes.get("@isNullable") map {
    _.as[Boolean]
  }
}


trait EnforceMode

object EnforceMode {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.EnforceMode]): EnforceMode = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: EnforceMode) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object FailFast extends EnforceMode {
  override def toString = "failFast"
}

case object DropMalformed extends EnforceMode {
  override def toString = "dropMalformed"
}

case object Permissive extends EnforceMode {
  override def toString = "permissive"
}


case class SchemaType(SchemaColumn: Seq[rex.core.xml.SchemaColumnType] = Nil,
                      attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val enforceMode = attributes.get("@enforceMode") map {
    _.as[EnforceMode]
  }
}


trait JoinType

object JoinType {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.JoinType]): JoinType = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: JoinType) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Inner extends JoinType {
  override def toString = "inner"
}

case object Full extends JoinType {
  override def toString = "full"
}

case object LeftType extends JoinType {
  override def toString = "left"
}

case object RightType extends JoinType {
  override def toString = "right"
}


case class JoinKey(attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val leftSideKey = attributes("@leftSideKey").as[String]
  lazy val rightSideKey = attributes("@rightSideKey").as[String]
}


case class JoinTransformType(RightSideJoiningData: String,
                             JoinKey: rex.core.xml.JoinKey,
                             Select: Option[rex.core.xml.ColumnListType] = None,
                             attributes: Map[String, scalaxb.DataRecord[Any]] = Map()) {
  lazy val joinType = attributes("@joinType").as[JoinType]
}


trait ColumnDataType

object ColumnDataType {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.ColumnDataType]): ColumnDataType = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ColumnDataType) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object IntegerType extends ColumnDataType {
  override def toString = "integerType"
}

case object StringType extends ColumnDataType {
  override def toString = "stringType"
}

case object DoubleType extends ColumnDataType {
  override def toString = "doubleType"
}

trait ExportFormat

object ExportFormat {
  def fromString(value: String, scope: scala.xml.NamespaceBinding)(implicit fmt: scalaxb.XMLFormat[rex.core.xml.ExportFormat]): ExportFormat = fmt.reads(scala.xml.Text(value), Nil) match {
    case Right(x: ExportFormat) => x
    case x => throw new RuntimeException(s"fromString returned unexpected value $x for input $value")
  }
}

case object Csv extends ExportFormat {
  override def toString = "csv"
}

case object Parquet extends ExportFormat {
  override def toString = "parquet"
}

case object Avro extends ExportFormat {
  override def toString = "avro"
}

case object Json extends ExportFormat {
  override def toString = "json"
}


case class PartitionType(DatePartitionFormat: Option[String] = None,
                         ColumnPartition: Option[rex.core.xml.ColumnListType] = None)
      

