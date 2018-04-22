package com.example.ryota.androidtest31.db;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Weath_DAO_Impl implements Weath_DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfWeathRow;

  public Weath_DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeathRow = new EntityInsertionAdapter<WeathRow>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `WeathRow`(`day`,`image`,`weather`,`max`,`min`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeathRow value) {
        if (value.getDay() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDay());
        }
        if (value.getImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImage());
        }
        if (value.getWeather() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getWeather());
        }
        if (value.getMax() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMax());
        }
        if (value.getMin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMin());
        }
      }
    };
  }

  @Override
  public void insert(WeathRow... weathRows) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeathRow.insert(weathRows);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<WeathRow> getAll() {
    final String _sql = "SELECT * FROM WeathRow";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDay = _cursor.getColumnIndexOrThrow("day");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfWeather = _cursor.getColumnIndexOrThrow("weather");
      final int _cursorIndexOfMax = _cursor.getColumnIndexOrThrow("max");
      final int _cursorIndexOfMin = _cursor.getColumnIndexOrThrow("min");
      final List<WeathRow> _result = new ArrayList<WeathRow>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WeathRow _item;
        _item = new WeathRow();
        final String _tmpDay;
        _tmpDay = _cursor.getString(_cursorIndexOfDay);
        _item.setDay(_tmpDay);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        _item.setImage(_tmpImage);
        final String _tmpWeather;
        _tmpWeather = _cursor.getString(_cursorIndexOfWeather);
        _item.setWeather(_tmpWeather);
        final String _tmpMax;
        _tmpMax = _cursor.getString(_cursorIndexOfMax);
        _item.setMax(_tmpMax);
        final String _tmpMin;
        _tmpMin = _cursor.getString(_cursorIndexOfMin);
        _item.setMin(_tmpMin);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public WeathRow loadAllByIds(String selectDay) {
    final String _sql = "SELECT * FROM WeathRow WHERE day IN (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (selectDay == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, selectDay);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfDay = _cursor.getColumnIndexOrThrow("day");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfWeather = _cursor.getColumnIndexOrThrow("weather");
      final int _cursorIndexOfMax = _cursor.getColumnIndexOrThrow("max");
      final int _cursorIndexOfMin = _cursor.getColumnIndexOrThrow("min");
      final WeathRow _result;
      if(_cursor.moveToFirst()) {
        _result = new WeathRow();
        final String _tmpDay;
        _tmpDay = _cursor.getString(_cursorIndexOfDay);
        _result.setDay(_tmpDay);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        _result.setImage(_tmpImage);
        final String _tmpWeather;
        _tmpWeather = _cursor.getString(_cursorIndexOfWeather);
        _result.setWeather(_tmpWeather);
        final String _tmpMax;
        _tmpMax = _cursor.getString(_cursorIndexOfMax);
        _result.setMax(_tmpMax);
        final String _tmpMin;
        _tmpMin = _cursor.getString(_cursorIndexOfMin);
        _result.setMin(_tmpMin);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
