package com.example.famcinematic;

import android.Manifest;
import android.content.pm.PackageManager;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class RateModeActivity extends Activity {
    private Button submitButton;
    private static final int PERMISSIONS_REQUEST_CODE = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_mode);

        checkPermissions();

        EditText directoryPathEditText = findViewById(R.id.directory_path_edit_text);

        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.submit_button:
                        String directoryPath = directoryPathEditText.getText().toString();
                        File directory = new File(directoryPath);

                        if (directory.exists() && directory.isDirectory()) {
                            File[] files = directory.listFiles();

                            if (files != null && files.length > 0) {
                                for (File file : files) {
                                    if (file.isFile()) {
                                        String fileName = file.getName();

                                        if (fileName.endsWith(".xls")) {
                                            try {
                                                Workbook workbook = Workbook.getWorkbook(file);
                                                Sheet sheet = workbook.getSheet(0);
                                                int emptyCellCount = 0;

                                                for (int i = 0; i < sheet.getRows(); i++) {
                                                    Cell cell = sheet.getCell(2, i);
                                                    if (cell == null || cell.getContents().isEmpty()) {
                                                        emptyCellCount++;

                                                        // Get the movie name from the first column
                                                        Cell movieCell = sheet.getCell(0, i);
                                                        String movieName = movieCell.getContents();

                                                        // Create an intent to start the movie activity
                                                        Intent intent = new Intent(RateModeActivity.this, RateMovieActivity.class);
                                                        intent.putExtra("movie_name", movieName);
                                                        startActivity(intent);
                                                    }
                                                }

                                                if (emptyCellCount == 0) {
                                                    Toast.makeText(RateModeActivity.this, "No empty cells found", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    Toast.makeText(RateModeActivity.this, "Found " + emptyCellCount + " empty cells", Toast.LENGTH_SHORT).show();
                                                }
                                            } catch (IOException | BiffException e) {
                                                e.printStackTrace();
                                                Toast.makeText(RateModeActivity.this, "Error reading file: " + fileName, Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                            } else {
                                Toast.makeText(RateModeActivity.this, "No files found in directory", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RateModeActivity.this, "Invalid directory path", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }

        });
        }

    //checker for method page onClick
    private void checkPermissions() {
        int readPermission = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            readPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        int writePermission = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            writePermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (readPermission != PackageManager.PERMISSION_GRANTED || writePermission != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_CODE);
            }
        } else {
            Toast.makeText(this, "Storage permission granted", Toast.LENGTH_SHORT).show();
        }
    }

    //invoked via Android system, needed for system storage via Manifest
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Storage permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
