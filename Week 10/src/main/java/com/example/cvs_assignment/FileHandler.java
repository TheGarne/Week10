package com.example.cvs_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private String file = "";
    private List<Movie> movieList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void readFile(String file){
        file = "movie_metadata_500.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String row;

            while ((row = bufferedReader.readLine()) != null) {
                String[] data = row.split(",");

                try{
                    /*
                    color	director_name	num_critic_for_reviews	duration	director_facebook_likes	actor_3_facebook_likes actor_2_name
                    actor_1_facebook_likes	gross	genres	actor_1_name	movie_title	num_voted_users	cast_total_facebook_likes actor_3_name	facenumber_in_poster
                    plot_keywords	movie_imdb_link	num_user_for_reviews	language	country	content_rating	budget
                    title_year	actor_2_facebook_likes	imdb_score	aspect_ratio	movie_facebook_likes
                     */

                    Movie movie = new Movie(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
                            data[7], data[8], data[9], data[10], data[11], data[12], data[13], data[14],
                            data[15], data[16], data[17], data[18], data[19], data[20], data[21], data[22],
                            data[23], data[24], Double.parseDouble(data[25]), data[26], data[27]);

                    movieList.add(movie);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a String: " + data[25]);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getBasicData(){
        for(Movie movie : movieList) {
            System.out.println(movie.getMovie_title() +
                    "\nRelease Year: " + movie.getTitle_year() +
                    "\nDirector: " + movie.getDirector_name() +
                    "\nRating: " + movie.getImdb_score() +
                    "\nPrimary Actor: " + movie.getActor_1_name() +
                    "\n");
        }
    }

    public void generateCSVFile(){
        try{
            System.out.println("Write file name: ");
            String fileName = input.nextLine();

            String csvFile = fileName + ".csv";
            FileWriter fileWriter = new FileWriter(csvFile);

            //TODO let user decide which colums to export?
            fileWriter.append("Movie_Title");
            fileWriter.append(',');
            fileWriter.append("IMDB_Score");
            fileWriter.append(',');
            fileWriter.append("Release_Year");
            fileWriter.append(',');
            fileWriter.append("Director_Name");
            fileWriter.append(',');
            fileWriter.append("Actor_1_Name");
            fileWriter.append(',');
            fileWriter.append("Actor_2_Name");
            fileWriter.append(',');
            fileWriter.append("Actor_3_Name");
            fileWriter.append(',');
            fileWriter.append("Genres");
            fileWriter.append(',');
            fileWriter.append("IMDB_Link");
            fileWriter.append('\n');

            //TODO let user decide which colums to export?
            for(Movie movie : movieList) {
                fileWriter.append(movie.getMovie_title());
                fileWriter.append(',');
                fileWriter.append(Double.toString(movie.getImdb_score()));
                fileWriter.append(',');
                fileWriter.append(movie.getTitle_year());
                fileWriter.append(',');
                fileWriter.append(movie.getDirector_name());
                fileWriter.append(',');
                fileWriter.append(movie.getActor_1_name());
                fileWriter.append(',');
                fileWriter.append(movie.getActor_2_name());
                fileWriter.append(',');
                fileWriter.append(movie.getActor_3_name());
                fileWriter.append(',');
                fileWriter.append(movie.getGenres());
                fileWriter.append(',');
                fileWriter.append(movie.getMovie_imdb_link());
                fileWriter.append('\n');
            }

            fileWriter.flush();
            fileWriter.close();
            System.out.println("CSV file with the name '" + fileName + " ' generated!");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void searchOneMovie(){
        Scanner input = new Scanner(System.in);
        System.out.println("Search for Movie Title: ");
        String search = input.next();

        for(Movie movie : movieList) {
            if(movie.getMovie_title().contains(search)){
                System.out.println(movie.toStringSimple());
            }
        }
    }

    public void sortByRating() {
        movieList.sort(Comparator.comparingDouble(Movie::getImdb_score));
        for(Movie movie : movieList) {
            System.out.println(movie.toStringSimple());
        }
    }
}