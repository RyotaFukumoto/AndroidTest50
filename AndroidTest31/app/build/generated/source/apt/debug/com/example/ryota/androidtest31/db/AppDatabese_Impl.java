package com.example.ryota.androidtest31.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class AppDatabese_Impl extends AppDatabese {
  private volatile Weath_DAO _weathDAO;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WeathRow` (`day` TEXT NOT NULL, `image` TEXT, `weather` TEXT, `max` TEXT, `min` TEXT, PRIMARY KEY(`day`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"ec4e3078d5baa42163970844116e4c98\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `WeathRow`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWeathRow = new HashMap<String, TableInfo.Column>(5);
        _columnsWeathRow.put("day", new TableInfo.Column("day", "TEXT", true, 1));
        _columnsWeathRow.put("image", new TableInfo.Column("image", "TEXT", false, 0));
        _columnsWeathRow.put("weather", new TableInfo.Column("weather", "TEXT", false, 0));
        _columnsWeathRow.put("max", new TableInfo.Column("max", "TEXT", false, 0));
        _columnsWeathRow.put("min", new TableInfo.Column("min", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWeathRow = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWeathRow = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWeathRow = new TableInfo("WeathRow", _columnsWeathRow, _foreignKeysWeathRow, _indicesWeathRow);
        final TableInfo _existingWeathRow = TableInfo.read(_db, "WeathRow");
        if (! _infoWeathRow.equals(_existingWeathRow)) {
          throw new IllegalStateException("Migration didn't properly handle WeathRow(com.example.ryota.androidtest31.db.WeathRow).\n"
                  + " Expected:\n" + _infoWeathRow + "\n"
                  + " Found:\n" + _existingWeathRow);
        }
      }
    }, "ec4e3078d5baa42163970844116e4c98");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "WeathRow");
  }

  @Override
  public Weath_DAO weath_dao() {
    if (_weathDAO != null) {
      return _weathDAO;
    } else {
      synchronized(this) {
        if(_weathDAO == null) {
          _weathDAO = new Weath_DAO_Impl(this);
        }
        return _weathDAO;
      }
    }
  }
}
