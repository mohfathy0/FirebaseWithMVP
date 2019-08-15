package com.example.firebasewithmvp;

import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainRepository implements IMainRepository {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference ref = db.collection("users").document("Profile1");

    @Override
    public void LoadData(final DatabaseCallback databaseCallback){
       final MainModel model = new MainModel();
        ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                model.setFirstName(documentSnapshot.getString("firstName"));
                model.setLastName(documentSnapshot.getString("lastName"));
                model.setEmail(documentSnapshot.getString("email"));
                model.setActive(documentSnapshot.getBoolean("active"));
                databaseCallback.onCallback(model);
                SendLog("From onSuccess "+model.getFirstName()  +" "+ model.getLastName() +" "+ model.getEmail());
            }
        });

    }

    String TAG="MyLog_Repository";
    public void SendLog(String Message){
        Log.i(TAG,Message);
    }
        interface DatabaseCallback{
            void onCallback(MainModel model);
        }
}
