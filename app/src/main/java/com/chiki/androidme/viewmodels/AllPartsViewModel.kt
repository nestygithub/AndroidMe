package com.chiki.androidme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chiki.androidme.data.AndroidImageAssets
import com.chiki.androidme.data.BodyPart

class AllPartsViewModel: ViewModel() {

    //Logic
    private val headParts = mutableListOf<BodyPart>()           //Available Heads
    private val bodyParts = mutableListOf<BodyPart>()           //Available bodies
    private val legsParts = mutableListOf<BodyPart>()           //Available legs

    //States to observe
    private var _allParts = MutableLiveData<List<BodyPart>>()   //All Heads,Bodies and Legs
    val allParts:LiveData<List<BodyPart>> get() = _allParts
    private var _currentHead = MutableLiveData<BodyPart>()      //Current head to show
    val currentHead:LiveData<BodyPart> get() = _currentHead
    private var _currentBody = MutableLiveData<BodyPart>()      //Current body to show
    val currentBody:LiveData<BodyPart> get() = _currentBody
    private var _currentLegs = MutableLiveData<BodyPart>()      //Current legs to show
    val currentLegs:LiveData<BodyPart> get() = _currentLegs

    //Events to observe
    private var _navigateToAllPartsFragment = MediatorLiveData<Boolean>()           //Tells when to navigate
    val navigateToAllPartsFragment:LiveData<Boolean> get() = _navigateToAllPartsFragment

    //Lifecycle
    init {
        getAllParts()
        onHeadClicked()     //Selects the first Head
        onBodyClicked()     //Selects the first Body
        onLegsClicked()     //Selects the first Legs
    }

    //Users Inputs
    fun onHeadClicked(){
        if(headParts.isEmpty()){
            resetHeadsList()
        }
        _currentHead.value = headParts.removeAt(0)
    }
    fun onBodyClicked(){
        if(bodyParts.isEmpty()){
            resetBodiesList()
        }
        _currentBody.value = bodyParts.removeAt(0)
    }
    fun onLegsClicked(){
        if(legsParts.isEmpty()){
            resetLegsList()
        }
        _currentLegs.value = legsParts.removeAt(0)
    }
    fun onShowButtonClicked(){
        _navigateToAllPartsFragment.value = true
    }
    fun onGridBodyPartClicked(position:Int){
        when(position/12){
            0-> {
                _currentHead.value = allParts.value?.get(position)
            }
            1-> {
                _currentBody.value = allParts.value?.get(position)
            }
            else-> {
                _currentLegs.value = allParts.value?.get(position)
            }
        }
    }

    //Actions
    private fun getAllParts(){
        _allParts.value = AndroidImageAssets().all
    }
    private fun resetHeadsList(){
        headParts.addAll(AndroidImageAssets().heads.shuffled())
    }
    private fun resetBodiesList(){
        bodyParts.addAll(AndroidImageAssets().bodies.shuffled())
    }
    private fun resetLegsList(){
        legsParts.addAll(AndroidImageAssets().legs.shuffled())
    }

    //Events
    fun doneNavigateToAllPartsFragment(){
        _navigateToAllPartsFragment.value = false
    }
}