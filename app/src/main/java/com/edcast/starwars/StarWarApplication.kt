package com.edcast.starwars

import android.app.Application
import com.edcast.data.di.NetModule
import com.edcast.starwars.di.AppComponent
import com.edcast.starwars.di.AppModule
import com.edcast.starwars.di.DaggerAppComponent
import com.edcast.starwars.di.Injector
import com.edcast.starwars.di.subcomponent.character.CharacterListSubcomponent
import timber.log.Timber

class StarWarApplication : Application() , Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .netModule(NetModule(BuildConfig.baseUrl))
            .appModule(AppModule(applicationContext))
            .build()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun getCharacterListSubcomponent(): CharacterListSubcomponent {
        return appComponent.getCharacterListSubcomponent().create()
    }
}