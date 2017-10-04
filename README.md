# Retrofit-Android-Example
# As of now i am not doing what i have written below. I am just pulling information and showing it on the screen.

a basic overview

### You need to firstly understand what these requests(GET,PUT,POST,DELETE) are.
I'll try my best to give you a basic understanding but there are much much better explanations out there so once you are done and are comfortable with it please go and read them.

GET --> This is nothing but requesting information form a server.When you load say google.com the google servers are sending back a website to your browser. Then your browser is using that and loading the website.
Here we do a get request to a server an it returns us a list of JSON objects and that we use that information to display in our App.

POST --> This is also similar to GET but here we send a body with our request. This body here is also a JSON object.This is used to update and modify info.

PUT --> Used to create or overwrite information. works similar to POST.

DELETE --> used to delete . works similarly to POST,PUT.

So, a JSON (Javascript Object Notation) object looks something like this :~

	{
		"user1" : {
	     "name" : "Shekhar",
		"password" : "password",
		"profession" : "Android Developer",
		"id": 1
		}
	}

# Now, lets get Started with Retrofit.

## Step I
Open your build.gradle(app) file and inside dependencies add 

	dependencies { 

		//this if for the calls
		compile 'com.squareup.retrofit2:retrofit:2.2.0'

		//this is for serialising info. that is converting from Object to json , json to object.
	    compile 'com.squareup.retrofit2:converter-gson:2.2.0'

	    //These are used to log out the calls in the Android Monitor. 
	    compile 'com.squareup.okhttp3:logging-interceptor:3.4.1'Hhc
	    compile 'com.squareup.okhttp3:okhttp:3.4.1'
	}

## Step II
Now we create Models for our API calls.
create a folder called models in the root directory,
In that create a new java class.
Here for this example I am making users so i'll call it 'UserObject' . The name shoud be relevant to what it is to help you understand what it is later when you deal with a lot of models.
put in the fields that you want.

	public class UserObject{
		String name;
		String password;
		String profession;
		
		public String getUsername() {
    	    return username;
    	}

    	public void setUsername(String username) {
        	this.username = username;
    	}

		//Add the rest of getter setter objects.
	}

After you have created this you will have to create request for post/put calls and response objects also.



## Step III
Now we have to create a Client for out App.
Lets create a new package folder and create a folder where we'll put all these classed.
Create a class ApiClient (Name can be anything) and put all this in it.

	public class APIClient {
		// This is the server to which we will call.
	    public static final String BASE_URL = "http://api.themoviedb.org/3/";
	    private static Retrofit retrofit;

	    public static Retrofit getClient() {
	        if (retrofit == null) {
	            //This is used for logging. -->
	            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
	            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
	            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	            httpClient.addInterceptor(logging);
	            // <--

	            retrofit = new Retrofit
	                    .Builder()
	                    .baseUrl(BASE_URL)
	                    .client(httpClient.build())
	                    .addConverterFactory(GsonConverterFactory.create())
	                    .build();
	        }
	        return retrofit;
	    }
	}

## Step IV
Now create a Interface and in this interface we will define what all calls we are going to put.

This is where we'll put all the requests.
The code for the call goes like this.
		
		// the @Query will add to the url you are hitting. 
		@GET("the url you want to hit")
		Call<UserResponse> getList(@Query String query);
				//OR
		//So the id that we pass to the function goes here.
		@GET("url/{id}")
		Call<UserResponse> getList(@Path("id") int id);

So your class will look something like this.

		public interface APIInterface {

		@GET("/get")
		Call<List<UserObject>> getList();

		@GET("get")
		Call<List<UserResponse>> getUsers();
		}

## Stap V
This is an optional step but you can add custom functionality on Response here.
Basically you can divide the response into different functions according to your requirement.
What you need to do is create a class and make it implement the Callback interface.
It looks something like this.
		
	public abstract class ExperimentingCallback<T> implements Callback<T> {

	    public abstract void onDataArrived(T t);

	    public abstract void onError(String error);

	    @Override
	    public void onResponse(Call<T> call, Response<T> response) {
	        T t = response.body();
	        onDataArrived(t);
	    }

	    @Override
	    public void onFailure(Call call, Throwable t) {
	        onError("Call did'ent go thru . " + t.toString());
	        t.printStackTrace();
	    }
	}


## Step VI
Now all You have to do is make the call form wherever you want.

		APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
		Call<UserResponse> call = apiInterface.getList();
		call.enque(new ExperimentingCallback<>(){
			@Override
			public void onDataArrived()
			})










