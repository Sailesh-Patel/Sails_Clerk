import "./Home.css";

<html lang="en"></html>

function Home() {
    return (
        <div>
            <br/>
            <br/>
            <h1 class="d-flex justify-content-center">"BUY WHOLESALE DRINKS”</h1>
            <br></br>
            <h3>
            About Patrk Cash and Carry Wholesale
</h3>
<p>
    Welcome to the world of “Smart Wholesaling”, the UK fastest growing drinks business to business wholesale marketplace.   
</p>
  
<p>
    As a national drinks wholesaler, we can offer our members beer, champagne, wine, spirits and soft drink at wholesale prices.  We offer an extensive range of products, very competitive prices; delivered nationwide in as little as 48 hours. Joining our buying group is a “Smart Decision”.
</p>

<p>
    We are one of the fastest growing alcohol drink wholesale suppliers in the UK. and welcome the opportunity to work with our future members.  We supply Restaurants, Clubs, Sport centres; Event companies, Pubs, Hotels, Retailers and other wholesalers, with best in class services and competitive prices.

</p>

<p>
   We offer Free fast nationwide deliveries*, 6 days a week (including Saturdays), and we can deliver your entire order in a little as 48 hours.  
</p>
<br></br>

 <p>
 Contact us for more information.
 </p>

       
<container className="container">
<form className='form'>

  <div class="form-group">
    <label for="exampleInputEmail1">Email address:</label>
    <br></br>
    <input type="email" class="col-xs-4" id="leInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" ></input>
    <br></br>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
  <br></br>
  <div class="form-group">
    <label for="InputComment">Comment:</label>
    <br></br>
    <textarea type="comment" class="col-xs-4" id="InputComment" placeholder="Comment" ></textarea>
  </div>
  <div class="form-check">    
  <br></br>
    <input type="checkbox" class="form-check-input" id="exampleCheck1"></input>
    <label class="form-check-label" for="exampleCheck1">Check me to opt out of marketing</label> 
  </div>
  <br></br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</container>

        </div>
    );
}

export default Home;