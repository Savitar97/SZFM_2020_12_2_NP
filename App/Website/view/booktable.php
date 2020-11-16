<!-- ======= Book A Table Section ======= -->
<section id="book-a-table" class="book-a-table asztalfoglalas">
      <div class="container">

        <div class="section-title">
          <h2>Asztalfoglalás:</h2>
          <p>Foglalj asztalt gyorsan és egyszerűen a weben keresztül.</p>
        </div>

        <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form">
          <div class="form-row">
            <div class="col-lg-4 col-md-6 form-group">
              <input type="text" name="name" class="form-control" id="name" placeholder="Név" data-rule="minlen:4" data-msg="A név legalább 4 karakterből álljon!" required>
              <div class="validate"></div>
            </div>
            <div class="col-lg-4 col-md-6 form-group">
              <input type="email" class="form-control" name="email" id="email" placeholder="Email" data-rule="email" data-msg="Adj meg egy valós email címet!" required>
              <div class="validate"></div>
            </div>
            <div class="col-lg-4 col-md-6 form-group">
              <input type="text" class="form-control" name="phone" id="phone" placeholder="Telefonszám" data-rule="minlen:9" data-msg="Legalább 9 karakternek kell lennie a telefonszámnak!" required>
              <div class="validate"></div>
            </div>
            <div class="col-lg-4 col-md-6 form-group">
              <input type="text" name="date" class="form-control" id="date" placeholder="Dátum" data-rule="minlen:10" data-msg="YYYY.MM.DD formátumban add meg a dátumot!" required>
              <div class="validate"></div>
            </div>
            <div class="col-lg-4 col-md-6 form-group">
              <select class="form-control" name="idopont" id="idopont" required>
              <option value="">Időpont</option>
              </select>
            </div>
            <div class="col-lg-4 col-md-6 form-group">
              <input type="number" class="form-control" name="people" id="people" placeholder="# személy" data-rule="min:1" data-msg="Legalább egy karakter hosszúnak kell lennie!" required pattern="[0-9][0-9]:[0-9][0-9]">
              <div class="validate"></div>
            </div>
          </div>
          <div class="mb-3">
            <div class="loading">Loading</div>
            <div class="error-message"></div>
            <div class="sent-message">Your booking request was sent. We will call back or send an Email to confirm your reservation. Thank you!</div>
          </div>
          <div class="text-center"><button type="submit">Foglalás</button></div>
        </form>

      </div>
    </section><!-- End Book A Table Section -->