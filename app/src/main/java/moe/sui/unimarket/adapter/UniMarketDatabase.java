package moe.sui.unimarket.adapter;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = UniMarketDatabase.NAME, version = UniMarketDatabase.VERSION)
public class UniMarketDatabase {

    public static final String NAME = "AppDatabase";

    public static final int VERSION = 2;
}