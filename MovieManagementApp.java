class Movie{
    String title,director;
    int yearOfRelease;
    double rating;
    Movie next,prev;
    public Movie(String title,String director,int yearOfRelease,double rating){
        this.title=title;
        this.director=director;
        this.yearOfRelease=yearOfRelease;
        this.rating=rating;
        this.next=null;
        this.prev=null;
    }
}
class MovieManagementSystem{
    Movie head,tail;
    public MovieManagementSystem(){
        head=null;
        tail=null;
    }
    public void addMovieAtBeginning(String title,String director,int yearOfRelease,double rating){
        Movie newMovie=new Movie(title,director,yearOfRelease,rating);
        if(head==null){
            head=newMovie;
            tail=newMovie;
        }else{
            newMovie.next=head;
            head.prev=newMovie;
            head=newMovie;
        }
    }
    public void addMovieAtEnd(String title,String director,int yearOfRelease,double rating){
        Movie newMovie=new Movie(title,director,yearOfRelease,rating);
        if(head==null){
            head=newMovie;
            tail=newMovie;
        }else{
            tail.next=newMovie;
            newMovie.prev=tail;
            tail=newMovie;
        }
    }
    public void addMovieAtPosition(int position,String title,String director,int yearOfRelease,double rating){
        if(position==1){
            addMovieAtBeginning(title,director,yearOfRelease,rating);
        }else{
            Movie newMovie=new Movie(title,director,yearOfRelease,rating);
            Movie temp=head;
            for(int i=1;i<position-1;i++){
                temp=temp.next;
            }
            newMovie.next=temp.next;
            if(temp.next!=null) temp.next.prev=newMovie;
            temp.next=newMovie;
            newMovie.prev=temp;
        }
    }
    public void removeMovieByTitle(String title){
        if(head==null) return;
        if(head.title.equals(title)){
            if(head.next!=null){
                head=head.next;
                head.prev=null;
            }else{
                head=null;
                tail=null;
            }
            return;
        }
        Movie temp=head;
        while(temp!=null&&!temp.title.equals(title)){
            temp=temp.next;
        }
        if(temp!=null){
            if(temp.next!=null){
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }else{
                temp.prev.next=null;
                tail=temp.prev;
            }
        }
    }
    public Movie searchMovieByDirectorOrRating(String director,double rating){
        Movie temp=head;
        while(temp!=null){
            if(temp.director.equalsIgnoreCase(director)||temp.rating==rating) return temp;
            temp=temp.next;
        }
        return null;
    }
    public void displayMoviesForward(){
        if(head==null){
            System.out.println("No movies available.");
            return;
        }
        Movie temp=head;
        while(temp!=null){
            System.out.println("Title: "+temp.title+" Director: "+temp.director+" Year: "+temp.yearOfRelease+" Rating: "+temp.rating);
            temp=temp.next;
        }
    }
    public void displayMoviesReverse(){
        if(tail==null){
            System.out.println("No movies available.");
            return;
        }
        Movie temp=tail;
        while(temp!=null){
            System.out.println("Title: "+temp.title+" Director: "+temp.director+" Year: "+temp.yearOfRelease+" Rating: "+temp.rating);
            temp=temp.prev;
        }
    }
    public void updateMovieRating(String title,double newRating){
        Movie temp=head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                temp.rating=newRating;
                return;
            }
            temp=temp.next;
        }
    }
}
public class MovieManagementApp{
    public static void main(String[] args){
        MovieManagementSystem system=new MovieManagementSystem();
        system.addMovieAtEnd("Lagaan","Ashutosh Gowariker",2001,8.1);
        system.addMovieAtEnd("Dilwale Dulhania Le Jayenge","Aditya Chopra",1995,8.1);
        system.addMovieAtEnd("3 Idiots","Rajkumar Hirani",2009,8.4);
        system.addMovieAtBeginning("Sholay","Ramesh Sippy",1975,8.2);
        system.addMovieAtPosition(3,"Kabhi Khushi Kabhie Gham","Karan Johar",2001,7.4);
        system.displayMoviesForward();
        system.removeMovieByTitle("3 Idiots");
        system.displayMoviesForward();
        Movie movie=system.searchMovieByDirectorOrRating("Rajkumar Hirani",8.4);
        if(movie!=null) System.out.println("Movie Found: Title: "+movie.title+" Director: "+movie.director+" Year: "+movie.yearOfRelease+" Rating: "+movie.rating);
        system.updateMovieRating("Dilwale Dulhania Le Jayenge",8.3);
        system.displayMoviesReverse();
    }
}

