import domain.model.PurchaseMoney
import domain.model.lotto.LottoShop
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoShopTest {

    @Test
    fun `수동 로또의 개수는 구입한 로또 개수를 넘을 수 없다`() {
        val errorMessage = assertThrows<IllegalArgumentException> {
            LottoShop(PurchaseMoney(1000), 3)
        }
        assertThat(errorMessage.message).isEqualTo("[ERROR] 구입한 로또 개수를 초과했습니다.")
    }

    @Test
    fun `수동 로또의 개수는 음수일 수 없다`() {
        val errorMessage = assertThrows<IllegalArgumentException> {
            LottoShop(PurchaseMoney(1000), -1)
        }
        assertThat(errorMessage.message).isEqualTo("[ERROR] 음수일 수 없습니다.")
    }
}