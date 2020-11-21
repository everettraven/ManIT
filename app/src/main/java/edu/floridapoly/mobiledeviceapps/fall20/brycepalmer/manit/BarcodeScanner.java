package edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetectorOptions;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.wonderkiln.camerakit.CameraKitError;
import com.wonderkiln.camerakit.CameraKitEvent;
import com.wonderkiln.camerakit.CameraKitEventListener;
import com.wonderkiln.camerakit.CameraKitImage;
import com.wonderkiln.camerakit.CameraKitVideo;
import com.wonderkiln.camerakit.CameraView;

import java.util.List;

import dmax.dialog.SpotsDialog;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.Helper.GraphicOverlay;
import edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.Helper.RectOverlay;

public class BarcodeScanner extends AppCompatActivity {

    CameraView cameraView;
    Button btnDetect;
    AlertDialog waitingDialog;
    GraphicOverlay graphicOverlay;

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_scanner);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        graphicOverlay = (GraphicOverlay)findViewById(R.id.graphic_overlay);
        cameraView = (CameraView)findViewById(R.id.cameraview);
        btnDetect = (Button)findViewById(R.id.btn_detect);
        waitingDialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Please wait")
                .setCancelable(false)
                .build();

        btnDetect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cameraView.start();
                cameraView.captureImage();
                graphicOverlay.clear();

            }
        });

        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent) {

            }

            @Override
            public void onError(CameraKitError cameraKitError) {

            }

            @Override
            public void onImage(CameraKitImage cameraKitImage) {
                waitingDialog.show();
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap, cameraView.getWidth(), cameraView.getHeight(), false);
                cameraView.stop();

                renDetector(bitmap);
            }

            @Override
            public void onVideo(CameraKitVideo cameraKitVideo) {

            }
        });


    }

    private void renDetector(Bitmap bitmap) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        FirebaseVisionBarcodeDetectorOptions options = new FirebaseVisionBarcodeDetectorOptions.Builder()
                .setBarcodeFormats(
                        FirebaseVisionBarcode.FORMAT_QR_CODE,
                        FirebaseVisionBarcode.FORMAT_CODE_128
                )
                .build();
        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance().getVisionBarcodeDetector(options);

        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> firebaseVisionBarcodes) {
                        Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "success", Toast.LENGTH_SHORT).show();
                        processResult(firebaseVisionBarcodes);

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void processResult(List<FirebaseVisionBarcode> firebaseVisionBarcodes) {
        Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "processResult", Toast.LENGTH_SHORT).show();
        for (FirebaseVisionBarcode item : firebaseVisionBarcodes) {

            //Draw rectangle
            Rect rectBounds = item.getBoundingBox();
            RectOverlay rectOverlay = new RectOverlay(graphicOverlay, rectBounds);
            graphicOverlay.add(rectOverlay);


            Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "type", Toast.LENGTH_SHORT).show();
            int value_type = item.getValueType();
            //Toast.makeText(BarcodeScanner.this, item.getRawValue(), Toast.LENGTH_SHORT).show();



            switch (value_type) {
                case FirebaseVisionBarcode.TYPE_TEXT:
                {
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
                    builder.setMessage(item.getRawValue());
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "dialogDismiss", Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                        }
                    });
                    androidx.appcompat.app.AlertDialog dialog = builder.create();
                    dialog.show();
                    Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "dialogShow", Toast.LENGTH_SHORT).show();
                    Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, "text", Toast.LENGTH_SHORT).show();
                    Toast.makeText(edu.floridapoly.mobiledeviceapps.fall20.brycepalmer.manit.BarcodeScanner.this, item.getRawValue(), Toast.LENGTH_SHORT).show();
                    break;
                }


                case FirebaseVisionBarcode.TYPE_URL:
                {
                    //start browser url
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getRawValue()));
                    startActivity(intent);
                }
                break;

                case FirebaseVisionBarcode.TYPE_CONTACT_INFO:
                {
                    String info = new StringBuilder("Name: ")
                            .append(item.getContactInfo().getName().getFormattedName())
                            .append("\n")
                            .append("Address: ")
                            .append(item.getContactInfo().getAddresses().get(0).getAddressLines())
                            .append("\n")
                            .append("Email: ")
                            .append(item.getContactInfo().getEmails().get(0).getAddress())
                            .toString();
                    androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
                    builder.setMessage(info);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    androidx.appcompat.app.AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;

                default:
                    break;
            }
        }
        waitingDialog.dismiss();
    }
}