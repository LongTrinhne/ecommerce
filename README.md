API Documentation
1. Product - manage product
   
   GET: /api/product/get : Xem thông tin tất cả product
   GET: /api/product/get/{theId} : Xem thông tin product dựa trên ID
   POST: /api/product/create : Tạo 1 product mới
   PUT: /api/product/update{theID} : Cập nhật product đã tồn tại dựa trên ID
   DELETE: /api/product/delete{theID} : Xóa 1 product dựa trên id
   
2. Category - manage category
   
   GET: /api/category/get : Xem thông tin tất cả category hiện có
   POST: /api/category/create : Tạo 1 category mới
   DELETE: /api/category/delete{theID} : Xóa 1 category dựa trên id

3. Orders - manage order

   GET: /api/orders/get : Xem thông tin tất cả đơn đặt hàng
   GET: /api/orders/get/{theId} : Xem thông tin đơn đặt hàng dựa trên ID
   POST: /api/orders/create : Tạo 1 đơn đặt hàng mới
   PUT: /api/orders/update{theID} : Cập nhật đơn đặt hàng đã tồn tại dựa trên ID
   DELETE: /api/orders/delete{theID} : Xóa 1 đơn đặt hàng dựa trên id
