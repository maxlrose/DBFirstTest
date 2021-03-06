package com.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "order_product", schema = "db_first_test", catalog = "")
//@IdClass(OrderProductPK.class)
public class OrderProduct implements Serializable
{
//	@Embedded
//	@EmbeddedId
	private int quantity;
	private Product productByProductId;
	private Order1 order1ByOrderId;

	@Basic
	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderProduct that = (OrderProduct) o;

		//Objects.equals(slug, post.slug);

		return quantity == that.quantity;
	}

	//@Override
	public int hashCode() {
		return Objects.hash(quantity);
	}

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	@Id
	public Product getProductByProductId() {
		return productByProductId;
	}

	public void setProductByProductId(Product productByProductId) {
		this.productByProductId = productByProductId;
	}

	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
	@Id
	public Order1 getOrder1ByOrderId() {
		return order1ByOrderId;
	}

	public void setOrder1ByOrderId(Order1 order1ByOrderId) {
		this.order1ByOrderId = order1ByOrderId;
	}


}
