package dev.cephx.makeru.dialect.postgresql.expr;

import dev.cephx.makeru.expr.InvalidExpressionDefinitionException;
import dev.cephx.makeru.expr.StatementFormattingStrategy;
import dev.cephx.makeru.expr.constraint.UniqueConstraintSQLExpression;
import org.jetbrains.annotations.NotNull;

public class PostgreSQL15SQLStatementVisitor extends PostgreSQL91SQLStatementVisitor {
    public PostgreSQL15SQLStatementVisitor(StatementFormattingStrategy strategy) {
        super(strategy);
    }

    // support NULLS NOT DISTINCT
    @Override
    public void visitUniqueTableConstraint(@NotNull UniqueConstraintSQLExpression expr) {
        writeKeyword("unique ");
        if (!expr.isNullsDistinct()) {
            writeKeyword("nulls not distinct ");
        }
        write("(");
        if (expr.getColumnNames().isEmpty()) {
            throw new InvalidExpressionDefinitionException("At least one column must be specified in UNIQUE");
        }
        writeDelimited(expr.getColumnNames());
        write(")");
    }

    // support NULLS NOT DISTINCT
    @Override
    public void visitUniqueColumnConstraint(@NotNull UniqueConstraintSQLExpression expr) {
        writeKeyword(" unique");
        if (!expr.isNullsDistinct()) {
            writeKeyword(" nulls not distinct");
        }
    }
}
