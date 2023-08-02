package com.example.converterkotlin.persistence.pa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface PaRepository : JpaRepository<Pa, Long> {




    @Query(
        "SELECT PUB.V_BelegPos.Artikel, PUB.V_BelegKopf.Kunde, PUB.V_BelegKopf.BelegDatum, PUB.MS_SNR.Seriennummer, PUB.PP_Auftrag.RueckMeldeNr, PUB.PP_StkZeile.Artikel " +
                "FROM PUB.V_BelegPos " +
                "JOIN PUB.V_BelegKopf ON PUB.V_BelegKopf.Firma = PUB.V_BelegPos.Firma AND PUB.V_BelegKopf.BelegArt = PUB.V_BelegPos.BelegArt AND PUB.V_BelegKopf.ReferenzNr = PUB.V_BelegPos.ReferenzNr " +
                "JOIN PUB.MSL_SerialNoRef sr1 ON PUB.V_BelegPos.V_BelegPos_Obj = sr1.Origin_Obj " +
                "JOIN PUB.MS_SNR ms ON sr1.MS_SNR_Obj = ms.MS_SNR_OBJ " +
                "JOIN PUB.MSL_SerialNoRef sr2 ON ms.MS_SNR_OBJ = sr2.MS_SNR_Obj " +
                "JOIN PUB.PP_Auftrag pa ON pa.PP_Auftrag_Obj = sr2.Origin_Obj " +
                "JOIN PUB.PP_StkZeile ps ON ps.Firma = pa.Firma and ps.RueckMeldeNr = pa.RueckMeldeNr " +
                "WHERE PUB.V_BelegKopf.BelegArt = 'L' AND PUB.V_BelegKopf.AnlageDatum > :startDate AND PUB.V_BelegKopf.AnlageDatum < :endDate " +
                "AND (ms.SNRArt BETWEEN 100 AND 110 OR ms.SNRArt BETWEEN 400 AND 999) AND ms.SNRStatus = 70 ",
//                "AND SUBSTRING(ps.Artikel, 1, 3) = '140' " +

        //Mit PP_StkZeile rekursiv arbeiten
        nativeQuery = true
    )
    fun getCircuitExport(@Param("startDate") startDate: Date, @Param("endDate") endDate: Date): List<String>?

    @Query(
        "WITH RECURSIVE ArtikelHierarchie (Artikel, ParentArtikel) AS " +
                "    -- Basisabfrage: Artikel und ihre direkten Eltern\n" +
                "    SELECT Artikel, ParentArtikel " +
                "    FROM Stueckliste " +
                "    WHERE ParentArtikel IS NOT NULL " +

                "    UNION ALL\n" +

                "    -- Rekursive Abfrage: Artikel und ihre Eltern in der Stückliste\n" +
                "    SELECT s.Artikel, s.ParentArtikel\n" +
                "    FROM Stueckliste s\n" +
                "    JOIN ArtikelHierarchie a ON s.Artikel = a.ParentArtikel\n" +
                ")\n" +
                "SELECT DISTINCT Artikel\n" +
                "FROM ArtikelHierarchie;",
        nativeQuery = true
    )
    fun getAllParts(): List<String>?



    @Query(
        "select snrz.Seriennummer from PUB.MS_SNRZuordnung snrz where snrz.SeriennummerEinbau = '129558'",
        nativeQuery = true
    )
    fun test(): List<String>?


}

