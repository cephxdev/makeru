package dev.cephx.makeru.expr.table;

import dev.cephx.makeru.expr.StatementBaseSQLExpression;
import dev.cephx.makeru.expr.annotations.LimitedFeatureSupport;
import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.NotNull;

@Value
@With
@Builder
public class CreateTableSQLExpression implements StatementBaseSQLExpression {
    @LimitedFeatureSupport({
            "POSTGRESQL_15",
            "POSTGRESQL_14",
            "POSTGRESQL_13",
            "POSTGRESQL_12",
            "POSTGRESQL_11",
            "POSTGRESQL_10",
            "POSTGRESQL_9_6",
            "POSTGRESQL_9_5",
            "POSTGRESQL_9_4",
            "POSTGRESQL_9_3",
            "POSTGRESQL_9_2",
            "POSTGRESQL_9_1"
    })
    @lombok.Builder.Default
    boolean ifNotExists = false;
    @NotNull
    String tableName;
}
