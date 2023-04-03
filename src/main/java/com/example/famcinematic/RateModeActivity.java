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
                                                    Cell cell = sheet.getCell(24, i);
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

}
