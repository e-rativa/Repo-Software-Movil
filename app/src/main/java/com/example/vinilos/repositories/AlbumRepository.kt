package com.example.vinilos.repositories

import android.app.Application
import android.util.Log
import com.android.volley.VolleyError
import com.example.vinilos.models.Album
import com.example.vinilos.models.Prize
import com.example.vinilos.network.NetworkServiceAdapter

class AlbumRepository(val application: Application?) {

    fun postAlbum(
        album: Album,
        cbSuccess: (resp: Boolean) -> Unit,
        cbError: (resp: VolleyError) -> Unit
    ) {

        if(application!=null){
            NetworkServiceAdapter.getInstance(application).postAlbum(album, {
                Log.i("AlbumRepository", "Album Creado con Exito")
                cbSuccess(it)
            }, {
                Log.i("AlbumRepository", "Error en la creacion")
                cbError(it)
            }
            )
        }

    }

    fun getAlbums(cbSuccess: (resp: List<Album>) -> Unit, cbError: (resp: VolleyError) -> Unit) {
        if(application!=null) {
            NetworkServiceAdapter.getInstance(application).getAlbums({
                Log.i("AlbumRepository", "Obtuvo álbums con extio")
                cbSuccess(it)
            }, {
                Log.i("AlbumRepository", "Error en la obtención de álbums")
                cbError(it)
            }
            )
        }
    }
    fun getAlbum(albumId:Int,cbSuccess: (resp: Album) -> Unit, cbError: (resp: VolleyError) -> Unit) {

        if (application != null) {
            NetworkServiceAdapter.getInstance(application).getAlbum(albumId,
                {
                    Log.i("AlbumRepository", "Obtuvo ábum con extio")
                    cbSuccess(it)
                }, {
                    Log.i("AlbumRepository", "Error en la obtención de álbum")
                    cbError(it)
                }
            )
        }
    }

    fun getPrize(prizeId:Int, cbSuccess: (resp: Prize) -> Unit, cbError: (resp: VolleyError) -> Unit) {

        if (application != null) {
            NetworkServiceAdapter.getInstance(application).getPrize(prizeId,
                {
                    Log.i("PerformerRepository", "Obtuvo premio con extio")
                    cbSuccess(it)
                }, {
                    Log.i("PerformerRepository", "Error en la obtención de premio")
                    cbError(it)
                }
            )
        }
    }


}