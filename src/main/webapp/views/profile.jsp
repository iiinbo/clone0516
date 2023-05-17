
<section class="user-dashboard page-wrapper">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <ul class="list-inline dashboard-menu text-center">
          <li><a href="dashboard.html">Dashboard</a></li>
          <li><a href="order.html">Orders</a></li>
          <li><a href="address.html">Address</a></li>
          <li><a class="active"  href="/changeInfo">changeInfo</a></li>
        </ul>
        <div class="dashboard-wrapper dashboard-user-profile">
          <div class="media">
            <div class="pull-left text-center" href="#!">

            </div>
            <div class="media-body">
                <div class="media-body">
                    <ul class="user-profile-list">
                        <li><span>Full Name:</span>${userinfo.user_name}</li>
                        <li><span>Country:</span>${userinfo.user_address}</li>
                        <li><span>Phone:</span>${userinfo.user_contact}</li>
                        <li><span>Date of Birth:</span>${userinfo.user_birthday}</li>
                    </ul>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
