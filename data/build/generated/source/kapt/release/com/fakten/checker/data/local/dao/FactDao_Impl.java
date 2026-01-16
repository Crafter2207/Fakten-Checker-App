package com.fakten.checker.data.local.dao;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.fakten.checker.data.local.Converters;
import com.fakten.checker.data.local.entity.FactEntity;
import com.fakten.checker.domain.model.FactStatus;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class FactDao_Impl implements FactDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<FactEntity> __insertAdapterOfFactEntity;

  private final Converters __converters = new Converters();

  public FactDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFactEntity = new EntityInsertAdapter<FactEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `facts` (`id`,`statement`,`status`,`sources`,`checkDate`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final FactEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        if (entity.getStatement() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getStatement());
        }
        statement.bindText(3, __FactStatus_enumToString(entity.getStatus()));
        final String _tmp = __converters.fromList(entity.getSources());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, _tmp);
        }
        statement.bindLong(5, entity.getCheckDate());
      }
    };
  }

  @Override
  public Object insertFact(final FactEntity fact, final Continuation<? super Unit> $completion) {
    if (fact == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfFactEntity.insert(_connection, fact);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getFactById(final String id, final Continuation<? super FactEntity> $completion) {
    final String _sql = "SELECT * FROM facts WHERE id = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, id);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfStatement = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "statement");
        final int _columnIndexOfStatus = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "status");
        final int _columnIndexOfSources = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sources");
        final int _columnIndexOfCheckDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "checkDate");
        final FactEntity _result;
        if (_stmt.step()) {
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final String _tmpStatement;
          if (_stmt.isNull(_columnIndexOfStatement)) {
            _tmpStatement = null;
          } else {
            _tmpStatement = _stmt.getText(_columnIndexOfStatement);
          }
          final FactStatus _tmpStatus;
          _tmpStatus = __FactStatus_stringToEnum(_stmt.getText(_columnIndexOfStatus));
          final List<String> _tmpSources;
          final String _tmp;
          if (_stmt.isNull(_columnIndexOfSources)) {
            _tmp = null;
          } else {
            _tmp = _stmt.getText(_columnIndexOfSources);
          }
          _tmpSources = __converters.fromString(_tmp);
          final long _tmpCheckDate;
          _tmpCheckDate = _stmt.getLong(_columnIndexOfCheckDate);
          _result = new FactEntity(_tmpId,_tmpStatement,_tmpStatus,_tmpSources,_tmpCheckDate);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteFact(final String id, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM facts WHERE id = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, id);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __FactStatus_enumToString(@NonNull final FactStatus _value) {
    switch (_value) {
      case CONFIRMED: return "CONFIRMED";
      case PARTIALLY_CORRECT: return "PARTIALLY_CORRECT";
      case UNPROVEN: return "UNPROVEN";
      case INCORRECT: return "INCORRECT";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private FactStatus __FactStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "CONFIRMED": return FactStatus.CONFIRMED;
      case "PARTIALLY_CORRECT": return FactStatus.PARTIALLY_CORRECT;
      case "UNPROVEN": return FactStatus.UNPROVEN;
      case "INCORRECT": return FactStatus.INCORRECT;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
