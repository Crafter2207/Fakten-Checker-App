package com.fakten.checker.data.local;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.fakten.checker.data.local.dao.FactDao;
import com.fakten.checker.data.local.dao.FactDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class FactCheckerDatabase_Impl extends FactCheckerDatabase {
  private volatile FactDao _factDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "bd019aa5a4d008031b3608c4095cdf95", "a324fd7a3c8d4c9c94524f6fd809ba3a") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `facts` (`id` TEXT NOT NULL, `statement` TEXT NOT NULL, `status` TEXT NOT NULL, `sources` TEXT NOT NULL, `checkDate` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bd019aa5a4d008031b3608c4095cdf95')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `facts`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsFacts = new HashMap<String, TableInfo.Column>(5);
        _columnsFacts.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFacts.put("statement", new TableInfo.Column("statement", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFacts.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFacts.put("sources", new TableInfo.Column("sources", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFacts.put("checkDate", new TableInfo.Column("checkDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysFacts = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesFacts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFacts = new TableInfo("facts", _columnsFacts, _foreignKeysFacts, _indicesFacts);
        final TableInfo _existingFacts = TableInfo.read(connection, "facts");
        if (!_infoFacts.equals(_existingFacts)) {
          return new RoomOpenDelegate.ValidationResult(false, "facts(com.fakten.checker.data.local.entity.FactEntity).\n"
                  + " Expected:\n" + _infoFacts + "\n"
                  + " Found:\n" + _existingFacts);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "facts");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "facts");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(FactDao.class, FactDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public FactDao factDao() {
    if (_factDao != null) {
      return _factDao;
    } else {
      synchronized(this) {
        if(_factDao == null) {
          _factDao = new FactDao_Impl(this);
        }
        return _factDao;
      }
    }
  }
}
