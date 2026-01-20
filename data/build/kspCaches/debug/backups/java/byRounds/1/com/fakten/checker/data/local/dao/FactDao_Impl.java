package com.fakten.checker.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fakten.checker.data.local.Converters;
import com.fakten.checker.data.local.entity.FactEntity;
import com.fakten.checker.domain.model.FactStatus;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FactDao_Impl implements FactDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FactEntity> __insertionAdapterOfFactEntity;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteFact;

  public FactDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFactEntity = new EntityInsertionAdapter<FactEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `facts` (`id`,`statement`,`status`,`sources`,`checkDate`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FactEntity entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getStatement());
        final String _tmp = __converters.fromFactStatus(entity.getStatus());
        statement.bindString(3, _tmp);
        final String _tmp_1 = __converters.fromList(entity.getSources());
        statement.bindString(4, _tmp_1);
        statement.bindLong(5, entity.getCheckDate());
      }
    };
    this.__preparedStmtOfDeleteFact = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM facts WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertFact(final FactEntity fact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFactEntity.insert(fact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFact(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteFact.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteFact.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getFactById(final String id, final Continuation<? super FactEntity> $completion) {
    final String _sql = "SELECT * FROM facts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FactEntity>() {
      @Override
      @Nullable
      public FactEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStatement = CursorUtil.getColumnIndexOrThrow(_cursor, "statement");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfSources = CursorUtil.getColumnIndexOrThrow(_cursor, "sources");
          final int _cursorIndexOfCheckDate = CursorUtil.getColumnIndexOrThrow(_cursor, "checkDate");
          final FactEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpStatement;
            _tmpStatement = _cursor.getString(_cursorIndexOfStatement);
            final FactStatus _tmpStatus;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfStatus);
            _tmpStatus = __converters.toFactStatus(_tmp);
            final List<String> _tmpSources;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfSources);
            _tmpSources = __converters.fromString(_tmp_1);
            final long _tmpCheckDate;
            _tmpCheckDate = _cursor.getLong(_cursorIndexOfCheckDate);
            _result = new FactEntity(_tmpId,_tmpStatement,_tmpStatus,_tmpSources,_tmpCheckDate);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
